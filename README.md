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