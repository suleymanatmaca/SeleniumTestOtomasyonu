# SeleniumTestOtomasyonu
Proje kapsamında gerçekleştirlen adımalar;
1. http://www.n11.com<http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak
2. Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )
3. Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak 
4. Gelen sayfada samsung icin sonuc bulundugunu onaylayacak 
5. Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak
6. Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak 
7. Ekranin en ustundeki 'favorilerim' linkine tiklayacak 
8. Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak
9. Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak
10. Sayfada bu urunun artik favorilere alinmadigini onaylayacak.  
11. Çıkış

Proje, geliştirme ortamı IntelliJ IDEA da Java programlama dili  ile kodlanmıştır. Maven build aracı kullanılmıştır. BDD dili olarak Cucumber kullanılmıştır. 
Page Object pattern ve Screenplay pattern kullanılmıştır.
İşler Model-Task-Question lara bölünmüştür.
Kullanıcı adı şifre, aranacak kelime vb. parametreler json formatında saklanmıştır.
Browser, URL ve Data bilgileri base.properties dosyasından çekilmektedir.
Timeouts ve webdriver location bilgiler serenity.properties (default) dosyasından çekilmektedir.
Feature kodları genel olarak steps altındaki klasörde giriş-çıkış ve ürün işlemi  olarak iki farklı class ta yazılmıştır.
