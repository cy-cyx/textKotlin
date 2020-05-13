### @Jvm 注解

#### @JvmDefault

主要用于指定应为非抽象Kotlin接口成员生成JVM默认方法。  二进制码的不同

见text1.kt

``` java

// 使用注解

public interface interfaceA {
   @Nullable
   String getA();

   void setA(@Nullable String var1);

   @Nullable
   Integer getB();

   void setB(@Nullable Integer var1);

   @JvmDefault
   @NotNull
   default String getString() {
      return "A:" + this.getA() + "B:" + this.getB();
   }
}

// 不使用注解

public interface interfaceA {
   @Nullable
   String getA();

   void setA(@Nullable String var1);

   @Nullable
   Integer getB();

   void setB(@Nullable Integer var1);

   @NotNull
   String getString();

   @Metadata(
      mv = {1, 1, 15},
      bv = {1, 0, 3},
      k = 3
   )
   public static final class DefaultImpls {
      @NotNull
      public static String getString(interfaceA $this) {
         return "A:" + $this.getA() + "B:" + $this.getB();
      }
   }
}

```

*注意:需要kotlinTarget 1.8以上，显式配置 -Xjvm-default=compatibility*

``` java
kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = ['-Xjvm-default=compatibility']
    }

```

**freeCompilerArgs  可以修改kotlin的编译参数**

#### @JvmField

在kotlin中的参数都是private的，自动提供get/set方法，如果想直接指定参数为public，不提供set/get方法

见text2.kt

``` java
// 使用@jvmField

public final class text2 {
   @JvmField
   @Nullable
   public String A;
   private int B = 1;

   public final int getB() {
      return this.B;
   }

   public final void setB(int var1) {
      this.B = var1;
   }
}

// 不使用@JvmField

public final class text2 {
   @Nullable
   private String A;
   private int B = 1;

   @Nullable
   public final String getA() {
      return this.A;
   }

   public final void setA(@Nullable String var1) {
      this.A = var1;
   }

   public final int getB() {
      return this.B;
   }

   public final void setB(int var1) {
      this.B = var1;
   }
}

```

#### @JvmName

这个注解的主要用途就是告诉编译器生成的Java类或者方法的名称

见text3

在kotlin中一个文件默认按照文件名生成一个类

#### @JvmMultifileClass

这个注解让Kotlin编译器生成一个多文件类

见text4

#### @JvmOverloads

告诉Kotlin编译器为此函数生成替换默认参数值的重载

见text5

``` java
public final class Text5Kt {
   @JvmOverloads
   public static final void A(@Nullable Context context, @Nullable String url, @Nullable Bundle bundle, int requestCode) {
   }

   // $FF: synthetic method
   public static void A$default(Context var0, String var1, Bundle var2, int var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var2 = (Bundle)null;
      }

      if ((var4 & 8) != 0) {
         var3 = -1;
      }

      A(var0, var1, var2, var3);
   }

   @JvmOverloads
   public static final void A(@Nullable Context context, @Nullable String url, @Nullable Bundle bundle) {
      A$default(context, url, bundle, 0, 8, (Object)null);
   }

   @JvmOverloads
   public static final void A(@Nullable Context context, @Nullable String url) {
      A$default(context, url, (Bundle)null, 0, 12, (Object)null);
   }
}
```

*备注：kotlin 转 java 基本都是使用都是使用静态方法进行桥接的*

#### @JvmStatic

只是为了使Java和kotlin的交互更加友好

见text6

``` java
        text6.B();
        text6.getA();

        text6_1.Companion.getA();
        text6_1.Companion.B();
```

#### @Strictfp

同Java中的strictfg

浮点运算更加精确， 而且不会因为不同的硬件平台所执行的结果不一致

#### @Transient

某些变量不序列化

#### @Volatile

可见

#### @Synchronized

锁

#### @Throws

同Throws

### 循环

见 text8

涉及关键字 in downTo until step

### companion 和 object

见text9.kt

两种单例形式

``` java
object text9{
    val a = 1

    fun b(){}
}

public final class text9 {
   private static final int a = 1;
   public static final text9 INSTANCE;

   public final int getA() {
      return a;
   }

   public final void b() {
   }

   private text9() {
   }

   static {
      text9 var0 = new text9();
      INSTANCE = var0;
      a = 1;
   }
}
```

``` java
class text9_1 {
    companion object {
        val a = 1

        fun b() {}
    }

    fun c() {}
}
public final class text9_1 {
   private static final int a = 1;
   public static final text9_1.Companion Companion = new text9_1.Companion((DefaultConstructorMarker)null);

   public final void c() {
   }

   public static final class Companion {
      public final int getA() {
         return text9_1.a;
      }

      public final void b() {
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
```

两者的区别：object是加载时,并初始化一个静态的自己；companion objec是加载时,初始化一个
静态内部类(而不是自己，这便是区别，也是伴生对象名字的由来吧）

#### 内部类和静态内部类的区别

``` java
class text9_2 {

    // 静态内部类
    class clazz {

    }
}
public final class text9_2 {

   // 默认就是static final （因为kotlin的类，默认都是final，如果需要继承需要open修饰）
   public static final class clazz {
   }
}
```

``` java
class text9_3 {

    // 内部类
    inner class clazz {

    }
}
```

### lateinit 和 by lazy

见text10.kt

lateinit用于var非空

by lazy用于val惰性初始化

### by 关键字

见text11

可快速构建装饰者模式，可以替代继承

### 扩展

``` java
class text12 {

    var c = 1

    fun a() {
        System.out.print("a")
    }
}

fun text12.b() {
    System.out.print(c)
}
```
实际上使用装饰者的做法
```
public final class Text12_1Kt {
   public static final void b(@NotNull text12 $this$b) {
      Intrinsics.checkParameterIsNotNull($this$b, "$this$b");
      System.out.print($this$b.getC());
   }
}
```
定义的规则：
1、不能覆盖原有的同名方法

2、扩展成员变量，其实没有真正的扩展，扩展后的成员没有幕后变量filed,var必须有getset方法,
val必须有get方法

### 密封类

限制了有限的子类

注意：object和class 区别 object是一个单例，同时也是无参class

### 泛类

java 和 kotlin 区别

#### *类型擦除*

泛类仅存于编译期间,由编译器处理泛类，当编译成字节码后全部变成上界即

``` java
编译前：
public static class text<T> {
    T a;
}
编译后：
public static class text {
    Object a;
}

public static class text<T extands String> {
    T a;
}
编译后：
public static class text {
    String a;
}
```
因为泛类jdk 1.5 之后出现为了兼容之前版本(用反射即可以躲过泛类的规则)

#### 上界下界

**上界**：< ? extands T> T即为上界(父类)  对应 kotlin中的 **out**  =》生产者

**下界**：< ? super T> T即为下界(子类)  对应kotlin中的 **in**  =》消费者

#### java中的泛类



``` java
// 普通的泛类
public class text<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * <\? extends T> 接受包括他的子类
     * <\? super T> 接受包括他的父类
     * 解决了泛类没有继承性的问题
     */
    public void copy(text14<? extends T> src, text14<? super T> dst) {
        dst.setT(src.getT());
    }
}

// 加限制的泛类的上界
public static class text14<T extends cla2> {
    T a;
}

注意：没有限定下界
// public static class text14<T super cla2> {
    // T a;
// }
```

#### kotlin中泛类

``` java
// 最普通的泛类
class clazz1<T> {
    var a: T? = null

    fun copy(src: clazz1<out T>, dst: clazz1<in T>) {
        dst.a = src.a
    }
}

// 限制上界（泛类限制）
class clazz1<T：cla>{

}

// out 指定T用于生产者(仅用于返回)  协变
interface interface1<out T> {
    fun getA(): T
}

// 也可以消费者（输入）    逆变
interface interface1<in T> {
    fun getA(a:T)
}

// 类型投影
var cla1: clazz1<in String> = clazz1<Any>()


```

#### 类型投影
``` java

// 类型投影
var cla1: clazz1<in String> = clazz1<Any>()

```

#### 泛类限制
``` java
// 限制上界（泛类限制）
class clazz1<T：cla>{

}

// 常见的例子
// <T : Comparable<T>>
```
