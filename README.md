# EmployeeChallenge
This has been done by me based on a given case.

# Gereksinimler

-PostgreSQL

Ubuntu için
```
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
sudo apt-get -y install postgresql
```
Windows için
```
https://www.postgresql.org/download/windows/
```

# Kurulum
Git'i bilgisayarınıza kurun,
Proje deposunu klonlayın
```
git clone https://github.com/Batuhandgenc/EmployeeChallenge
```
Gradle build etmesini bekleyin.
İşlem bittiğinde batuhan/src/main/java/com.batuhan'a gelin.
BatuhanApplication'a sağ tıklayıp Run diyin. 
Uygulama çalıştıktan sonra 
```
http://localhost:8080/actuator/health
```
adresine gidin. 
```
{"status":"UP"}
```
Cevabı aldıysanız proje ayağa kalkmış demektir.

# Kullanım
Burada swagger üzerinden Company ve Employee'leri yöneten platformun kodlarını açıklayacağım. 

Employee üzerinde,

```
id,firstname,lastname,age,salary,creationDate ve company kısımları bulunmaktadır.
```

Company üzerinde,

```
id,name,description ve creationDate bulunmaktadır.
```

**/save** 
endpointi ile yeni bir şirket oluşturmak için, bir POST requesti gönderilebilir:
```
POST http://localhost:8080/save
Content-Type: application/json

{
    "name": "ACME Inc.",
    "description": "A company that makes everything"
}
```
**/update** 
endpointi ile bir şirketin bilgileri güncellenebilir:
```
PUT http://localhost:8080/update
Content-Type: application/json

{
    "id": 1,
    "name": "ACME Corporation",
    "description": "A company that makes everything and more"
}
```
**/delete/{id}** 
endpointi ile bir şirket silinebilir:
```
DELETE http://localhost:8080/delete/1
```
**/addNewEmployee/{companyId}** 
endpointi ile bir şirkete yeni bir çalışan eklenebilir:
```
POST http://localhost:8080/addNewEmployee/1
Content-Type: application/json

{
    "firstName": "John",
    "lastName": "Doe",
    "age": 30,
    "salary": 50000.0
}
```
**/listAllEmployees/{id}** endpointi, belirli bir şirkete ait tüm çalışanları listelemek için kullanılır. Endpoint'e GET isteği atarak çalışanların listesini alabilirsiniz. {id} parametresi, çalışanların listeleneceği şirketin kimliğini belirtir. Örneğin, "/listAllEmployees/1" endpointi, kimliği 1 olan şirketin tüm çalışanlarını listeler.

**/addNewEmployee/{companyId}** endpointi, belirli bir şirkete yeni bir çalışan eklemek için kullanılır. Endpoint'e POST isteği atarak yeni çalışanın ayrıntılarını gönderirsiniz. {companyId} parametresi, çalışanın eklenmesi gereken şirketin kimliğini belirtir. Örneğin, "/addNewEmployee/1" endpointi, kimliği 1 olan şirkete yeni bir çalışan ekler.

**/update** endpointi, bir çalışanın ayrıntılarını güncellemek için kullanılır. Endpoint'e PUT isteği atarak çalışanın güncellenmiş ayrıntılarını gönderirsiniz.

**/delete/{id}** endpointi, belirli bir çalışanı silmek için kullanılır. Endpoint'e DELETE isteği atarak silinecek çalışanın kimliğini gönderirsiniz. {id} parametresi, silinecek çalışanın kimliğini belirtir. Örneğin, "/delete/1" endpointi, kimliği 1 olan çalışanı siler.

# Ek bilgiler
Projeyi geliştirmek veya özelleştirmek isteyenler için backend tarafında Spring Framework, frontend tarafında React kullanılması düşünüyorum. Tasarım kararı olarak fronend tarafında Material UI kullanıldı ve authentication işlemleri JWT ile gerçekleşti.

Katkıda bulunmak isteyenler GitHub reposuna erişim sağlayarak, pull request göndermeden önce testlerden geçirmelerini rica ediyorum.
