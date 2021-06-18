# Setup

First, [set up a ssh key](https://support.atlassian.com/bitbucket-cloud/docs/set-up-an-ssh-key/) and add it to your Bitbucket account, then clone this repository using ssh!

```
git clone git@bitbucket.org:aguirreibarra/automation.git
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