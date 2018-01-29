<h1>What is this library? What can it do?</h1>
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
@AssingView(R.id.{viewId})
private TextView anotherName;
```

### I have a view and a variable with exact same names that I don't want them to bind?
You can use <b>BindStatus</b> annotation which has an enum for its status like this:

```
@BindStatus(BindStatus.Status.DO_NOT_BIND)
private View myView;
```
This way <b>myView</b> will not be bind.

This library also provides an easy way to use Fragment within Activities.
