# What is this library? What can it do?
So, there is some libraries that aim to ease using views because we have to <b>findViewById</b> every view! This library simply make it the easiest way it could be.

### How does it make that happens?
Every view that needs to bind to your <b>.java</b> files should have an <b>id</b>. So lets assume that your view (lets take it a TextView) id is: 

```
@+id/myTextView 
```
Then if your activity or fragment extends <b>BinderActivity</b> or <b>BinderFragment</b>, you just need to declare: 

```
private TextView myTextView 
```
and the view is binded automatically! So simple.

### I want to bind a view that its variable name is different with its id?
You can easily use <b>@AssignView</b> annotation like this:

```
@AssignView(R.id.{viewId})
private TextView anotherName;
```

### I have a view and a variable with exact same names that I don't want them to bind?
You can use <b>BindStatus</b> annotation which has an enum for its status like this:

```
@BindStatus(BindStatus.Status.DO_NOT_BIND)
private View myView;
```
This way <b>myView</b> will not be bind.

# How to add this library to your project?
In your project gradle file, add jitpack maven, so it should be like this:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Then in your app gradle file, add this dependancy, so it should be like this:

```
dependencies {
    compile 'com.github.shadowalker77:EaseItProject:0.0.11'
}
```
 After that, the only thing that you have to do is to extend <b>BinderActivity</b> or <b>BinderFragment</b> instead of default AppCompatActivity or Fragment.



This library also provides an easy way to use Fragment within Activities.
