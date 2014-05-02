instanceof-commons
======================

公開してますが個人用ライブラリです。
複数のプロジェクトで利用するので、分離して管理する。
基本的にゴミ溜めです。
個人用なので、過去のインターフェース等は保証しません。
dependencyのverionで全く違う事も有るかもしれません
アカウントも消す可能性が有るので
使用する人はリポジトリをforkしてください

機能
------
##色々
##jndiとspringとlogbackは必須となります。

備考
------
package名に予約語が有るので↓で対応

If any of the resulting package name components are keywords (§3.9) then append underscore to them.

maven等
------

repository
-----------
    <repository>
      <id>instanceof-commons-github</id>
      <url>https://raw.github.com/syuu256/instanceof-commons/mvn-repo/</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
    </repository>

dependency
-----------
    <dependency>
      <groupId>net._instanceof</groupId>
      <artifactId>instanceof-commons</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>



