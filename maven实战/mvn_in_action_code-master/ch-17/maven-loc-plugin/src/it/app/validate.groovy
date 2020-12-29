def file = new File(basedir, 'build.log')

def countMain = false
def countTest = false

file.eachLine {
  if ( it =~ /src.main.java: 13 lines of code in 1 files/ )
    countMain = true
  if ( it =~ /src.test.java: 38 lines of code in 1 files/ )
    countTest = true
}

if ( !countMain )
  throw new RuntimeException( "incorrect src/main/java count info" ); 
  
if ( !countTest )
  throw new RuntimeException( "incorrect src/test/java count info" ); 