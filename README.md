# use-sdk-demo
java编写一个简单的 SDK，导出并且用于另一个项目中

参考教程

https://blog.csdn.net/u012814856/article/details/113665071

https://www.panziye.com/java/3226.html

1. 新建文件夹use-sdk-demo

2. IDEA打开这个use-sdk-demo文件夹

3. 创建javascript的test-sdk项目和use-test-sdk项目，包含web依赖即可

4. 删除use-sdk项目的main文件夹，新建pers.wangying.testsdk文件夹，创建main主类文件TestSdk

```
package pers.wangying.testsdk;

public class TestSdk {
    public static void main(String[] args) {
        TestSdk testSdk = new TestSdk();
        testSdk.greeting();
    }

    public void greeting() {
        System.out.println("Hello, I am a test sdk.");
    }
}
```

5. File -> Project Structure，选择 Artifacts，点击 +，选中 JAR -> From modules with dependencies…

6. 在弹出来的窗体里，选中 test-sdk 我们想要导出的 sdk 项目，Main Class 选中 pers.wangying.testsdk.TestSdk，JAR files from libraries 选择 copy to the output directory and link via manifest。最后的 META-INF 的路径，需要手动编辑，修改为 test-sdk 下的 resource 目录即可。最后点击 OK

7. 选中 include in project build，点击 OK

8. Build -> Build Artifacts…，选中 test-sdk:jar 点击 Build 即可在默认的 test-sdk/out/artifacts/test_sdk_jar 目录下生成 test-sdk.jar 包

9. 这样，就生成了想要的 jar 包，可以在本地测试运行一下看看是否异常

10. 引用SDK：将 test-sdk.jar 拖放到 use-test-sdk/lib 下

11. 打开File->Project Structure，Modules->项目文件夹->+号->Library->Java

12. 然后选择之前项目中构建的test-sdk.jar 包，LEVEL默认Project Library,点击ok

13. 引入SDK使用

```
import pers.wangying.testsdk.TestSdk;

public class UseTestSdk {
    public static void main(String[] args) {
        TestSdk testSdk = new TestSdk();
        testSdk.greeting();
    }
}
```
