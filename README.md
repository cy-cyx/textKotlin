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
