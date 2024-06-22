class HelloNativeTest{
	public static  void main(String[] args){
		HelloNative.greeting();
	}
	static{
		System.loadLibrary("HelloNative");
	}
}