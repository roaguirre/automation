# Setup

```
git clone https://github.com/roaguirre/automation.git
```

* Install Java SDK
* Download Chrome

# How to run
On Intellij, create a JUnit run configuration, select the class ```com.aguirreibarra.automation.WebTest```. Then
add these VM options:

```
  -ea
  -Dstory.name=YoutubeSearch2 // Leave blank to run all stories
```
