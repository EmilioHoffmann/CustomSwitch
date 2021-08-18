# CustomSwitch
Just a simple custom switch, feel free to use/copy.

<img src="https://user-images.githubusercontent.com/13904560/129815320-06ce1c8a-84a5-4ca9-a627-c3fd8cce8f82.png" width="400">


https://user-images.githubusercontent.com/13904560/129816140-d46b38ec-5336-4e62-9fa7-58b080d83a55.mp4


## How to use it

``` xml
<com.hoffmann.emilio.custom_switch.CustomSwitch
    android:id="@+id/mainSwitch"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:firstOption="@string/first_option"
    app:secondOption="@string/second_option" />
```

####  Your activity/fragment


``` kotlin
binding.mainSwitch.setSwitchChangedListener {
    if (it == CustomSwitch.SwitchSelected.FIRST) {
        ...
    } else {
        ...
    }
}
```
