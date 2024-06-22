/**
   @version 1.10 1997-07-01
   @author Cay Horstmann
*/

#include "Printf4.h"
#include <string.h>
#include <stdlib.h>
#include <float.h>

/**
   @param format a string containing a printf format specifier
   (such as "%8.2f"). Substrings "%%" are skipped.
   @return a pointer to the format specifier (skipping the '%')
   or NULL if there wasn't a unique format specifier
 */
char* find_format(const char format[])
{  
   char* p;
   char* q;

   p = strchr(format, '%');
   while (p != NULL && *(p + 1) == '%') /* skip %% */
      p = strchr(p + 2, '%');
   if (p == NULL) return NULL;
   /* now check that % is unique */
   p++;
   q = strchr(p, '%');
   while (q != NULL && *(q + 1) == '%') /* skip %% */
      q = strchr(q + 2, '%');
   if (q != NULL) return NULL; /* % not unique */
   q = p + strspn(p, " -0+#"); /* skip past flags */
   q += strspn(q, "0123456789"); /* skip past field width */
   if (*q == '.') { q++; q += strspn(q, "0123456789"); }
      /* skip past precision */
   if (strchr("eEfFgG", *q) == NULL) return NULL;
      /* not a floating-point format */
   return p;
}

JNIEXPORT void JNICALL Java_Printf4_fprint(JNIEnv* env, jclass cl, 
   jobject out, jstring format, jdouble x)
{  
   const char* cformat;
   char* fmt;
   jclass class_PrintWriter;
   jmethodID id_print;
   char* cstr;
   int width;
   int i;

   if (format == NULL)
   {  
      (*env)->ThrowNew(env,
         (*env)->FindClass(env,
         "java/lang/NullPointerException"),
         "Printf4.fprint: format is null");
      return;
   }

   cformat = (*env)->GetStringUTFChars(env, format, NULL);
   fmt = find_format(cformat);

   if (fmt == NULL)
   {  
      (*env)->ThrowNew(env,
         (*env)->FindClass(env,
         "java/lang/IllegalArgumentException"),
         "Printf4.fprint: format is invalid");
      return;
   }

   width = atoi(fmt);
   if (width == 0) width = DBL_DIG + 10;
   cstr = (char*)malloc(strlen(cformat) + width);

   if (cstr == NULL)
   {  
      (*env)->ThrowNew(env,
         (*env)->FindClass(env, "java/lang/OutOfMemoryError"),
         "Printf4.fprint: malloc failed");
      return;
   }

   sprintf(cstr, cformat, x);

   (*env)->ReleaseStringUTFChars(env, format, cformat);

   /* now call ps.print(str) */

   /* get the class */
   class_PrintWriter = (*env)->GetObjectClass(env, out);

   /* get the method ID */
   id_print = (*env)->GetMethodID(env, class_PrintWriter, "print", "(C)V");

   /* call the method */
   for (i = 0; cstr[i] != 0 && !(*env)->ExceptionOccurred(env); i++)
      (*env)->CallVoidMethod(env, out, id_print, cstr[i]);

   free(cstr);
}





