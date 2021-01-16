# Fibabanka Java Bootcamp 3. Hafta Ödev

Ödev bir restoran simulasyonu. Restoranda 2 tane şef, 3 tane garson ve 5 tane de masa bulunuyor. Restoran sürekli açık
ve müşteriler restorana gelip boş masalara oturup garsonlara sipariş veriyor. Garsonlar da siparişleri şeflere iletip
daha sonra hazır olan siparişleri masalara dağıtıyor. Her müşterinin masada belli bir süre oturma hakkı olduğunu
düşünelim. Vakti dolan müşteri masadan kalkar ve yeni müşteriler restorana girer. Her masada bir müşteri oturabildiğini
ve müşterilerin teker teker restorana geldiğini varsayalım. Her müşteri istediği kadar sipariş verebilir ama masada
oturma süresi limitli.

Burada önemli olan gerçek hayatta olduğu gibi masalarda oturan müşterilerin, sipariş alan garsonların ve siparişleri
hazırlayan şeflerin gerçekten olduğu gibi birbirlerinden bağımsız çalışabilmesi ve her işlem sırasında ve sonrasında
simulasyonun doğru çalıştığını anlayabilmemiz için uygun logların ekrana basılması gerekir.

Ödev tamamen java dilinde multithread özelliğinin kullanılma yeteneğini ölçmeye yöneliktir. Her bir müşteriyi, garsonu
ve şefi birer thred olarak düşünebilirsiniz.

Ödev teslim tarihi 16 Ocak saat 00:00.

## Aciklamalar

- Uygulama teslim zamanina yakin zamanda yeniden refactor edilmek zorunda kalindi ve bir cok test yapilamadi.

- Uygulamada kullanilmasi istenilen temel konular ( Thread, Nesne gibi yapilar) kullanildi.

- Threadlerin asamalari asagidaki gibi log ekraninda gosterildi.



```java

Musteri_1,Masa_3'e oturdu.
Musteri_2,Masa_1'e oturdu.
Musteri_1,Garson_3'i cagirdi.
Musteri_2,Garson_2'i cagirdi.
Masa_3'den, Musteri_1' in 34birimlik durum siparisi olusturuldu.
Masa_1'den, Musteri_2' in 1birimlik durum siparisi olusturuldu.
Musteri_1'in siparisi Cheff_1' ye ulasti.
Cheff_1,3numarada oturan Musteri_1'in siparisini hazirlamak icin mutfaga girdi.
Garson_3,diger musteriler ile ilgilenmek uzere gezinmeye basladi.
Musteri_2'in siparisi Cheff_2' ye ulasti.
Cheff_2,1numarada oturan Musteri_2'in siparisini hazirlamak icin mutfaga girdi.
Garson_2,diger musteriler ile ilgilenmek uzere gezinmeye basladi.

Musteri_2'nin durumu eline ulasti, kurt gibi acikmis olmali ki boyle istahli yiyor.
27
Musteri_1'nin durumu eline ulasti, kurt gibi acikmis olmali ki boyle istahli yiyor.
0 1 5 6 6 7 7 7 8 10 12 13 15 15 15 17 17 18 18 18 19 20 21 22 22 23 24 24 25 25 25 26 26 28

```