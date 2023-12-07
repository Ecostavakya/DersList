bu proje intellij IDEA dan yaptım 
# Öğrenci ve Ders Kayıt Uygulaması

Bu uygulama, öğrenci ve ders kayıtlarını tutan basit bir Java Swing uygulamasıdır.

## Proje Yapısı

Proje, aşağıdaki paketlerden oluşmaktadır:

- **Forms:** Swing kullanarak oluşturulmuş kullanıcı arayüzü formları.
  - `DersKayitForm.java`: Ders kaydı yapmak için bir form.
  - `Menu.java`: Ana menü formu, ders ve öğrenci formlarına yönlendirir.
  - `OgrenciKayitForm.java`: Öğrenci kaydı yapmak için bir form.
- **Models:** Uygulama veri modelleri.
  - `Ders.java`: Ders modeli.
  - `Ogrenci.java`: Öğrenci modeli.
- **Services:** Dosya işlemleri ve veritabanı işlemleri için hizmet sınıfları.
  - `FileService.java`: Dosya işlemleri için hizmet sınıfı.
