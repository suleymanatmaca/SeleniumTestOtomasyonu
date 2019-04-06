@one
Feature: Giriş,Ürün Seçimi, Çıkış

  Scenario Outline: N11 sitesinde favorilere ürün eklenmesi ve kaldırılması
    Given Kullanıcı, N11 anasayfasını açar
    Then Kullanıcı, N11 <Başlık> ve <GirişYap> bilgisini görür
    And Giriş yap butonuna basar
    When <Kullanıcı> ve <Şifre> ile sisteme giriş yapar
    Then Search alanına <Search> yazar
    And Ara butonuna basar
    And Ürünleri görür
    Then 2. sayfaya tıklar
    And 2. sayfanın açık olduğunu görür
    Then Ustten 3. ürünün içindeki 'favorilere ekle' butonuna tıklar
    And Ekranın en üstündeki 'favorilerim' linkine tıklar
    And Açılan sayfada ilgili ürünün bulunduğunu doğrular
    Then 'Kaldir' butonuna basar
    And Ilgili ürünün favorilerimden çıkarılğını görür
    And Kullanıcı, çıkış yapar

    Examples:
      | Kullanıcı | Şifre | Search | Başlık | Anasayfa | Çıkış   | GirişYap |
      | USER      | PWD   | SEARCH | TITLE  | HOMEPAGE | LOG_OUT | SIGNIN   |