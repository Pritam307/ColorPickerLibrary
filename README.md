# ColorPickerLibrary


![Alt text](https://github.com/Pritam307/ColorPickerLibrary/blob/master/app/src/main/res/drawable/lib_demo1.png) 

![Alt text](https://github.com/Pritam307/ColorPickerLibrary/blob/master/app/src/main/res/drawable/lib_demo3.png) 

For Gradle:
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  Add the dependency:
  
  	dependencies {
    
	        compile 'com.github.Pritam307:ColorPickerLibrary:master-SNAPSHOT'
	}
  
For Maven:
Add the JitPack repository to your build file:

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  
  Add the dependency:
  
	<dependency>
	    <groupId>com.github.Pritam307</groupId>
	    <artifactId>ColorPickerLibrary</artifactId>
	    <version>master-SNAPSHOT</version>
	</dependency>


Use this in the layout.xml file:

    <com.pritamkundilya.colorpickerlibrary_pk.ColorPickerView
        android:layout_width="300dp"
        android:id="@+id/picker"
        android:layout_height="300dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="35dp" />

    <com.pritamkundilya.colorpickerlibrary_pk.ColorAlpha
        android:id="@+id/alphabar"
        android:max="255"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_margin="20dp"
        android:layout_below="@+id/picker"
        android:layout_centerHorizontal="true" />
        
  And this lines of code in activity:
  
         GetColor color;
        ColorPickerView view;
        ColorAlpha seekbar;
        ArrayList<Integer> val=new ArrayList<>();
        view= (ColorPickerView) findViewById(R.id.picker);
        seekbar= (ColorAlpha) findViewById(R.id.alphabar);
        color=new GetColor(getApplicationContext(),view,seekbar);
        color.extract();
     
     public void onClickColor(View v)
    {
        val=color.getRGB();
        Toast.makeText(getApplicationContext(),          "Alpha:"+val.get(0)+"Red:"+val.get(1)+"Green:"+val.get(2)+"Blue:"+val.get(3),Toast.LENGTH_LONG).show();
    }
    
    ....
}

