# Servlet
Adalah standarisasi di Java untuk membuat Web. Mirip seperti JDBC sebagai standarisasi untuk komunikasi dengan Database. <br/> 
Dengan menggunakan servlet, bisa menjalankan aplikasi Java Web di Web Server apapun yang sudah mengikuti standarisasi Servlet. <br/>
Servlet sendiri sangat low level, semua harus diatur manual. <br/>
Servlet hanya sebuah spesifikasi, maka harus ada implementasinya (Driver) berupa Web Server. <br/>
Driver yang bisa digunakan antara lain:
- Apache Tomcat
- Jetty
- Glassfish
- Wildfly
- dll

## Apache Tomcat
Adalah salah satu Web Server yang bisa digunakan untuk menjalankan Java Web. <br/>
Apache tomcat merupakan aplikasi Open Source dan Multi Platform (bisa dijalankan di berbagai sistem operasi) serta sangat ringan.

### Menginstall Apache Tomcat
- Download di `https://tomcat.apache.org`, pada bagian download pilih yg core dan dalam zip, kemudian extract.
- Jalankan file `catalina.sh` (untuk linux) atau `catalina.bat` (untuk windows) di folder bin dengan parameter:
- `run` untuk menjalankan di terminal saat ini, akan mati ketika tutup terminalnya.
- `start` untuk menjalankan di background, tidak akan mati meskipun menutup terminalnya.
- `stop` untuk menghentikan aplikasi.
- Setelah Apache Tomcat berjalan, bisa lihat Apache Toomcat di `http://localhost:8080`
- untuk di linux atau unix, biasanya harus membuat catalina.sh menjadi executable file dengan `chmod +x catalina.sh`

## War (Web Archive) File
Adalah distribution file khusus untuk Java Web. Isi file War dan Jar sebenarnya sama, berisi class-class Java yang sudah dicompile menjadi binary code. Salah satu yang membedakan adalah, di War file biasanya tidak terdapat main class, karena memang War file akan dijalankan di dalam Web Server.

## Interface Servlet
- Interface Servlet adalah interface utama dari Servlet API.
- Servlet merupakan tempat dimana logika kode program ditempatkan, HTTP Request yang masuk akan diterima oleh Servlet,  dan HTTP Response nya akan dibuat di Servlet.
- Method yang ada di Interface Servlet:
- `destroy()` --> akan dipanggil ketika servlet akan di destroy, biasanya ketika aplikasi akan di shutdown.
- `getServletConfig()`
- `getServletInfo()`
- `init(ServiceConfig config)`
- `service(ServiceRequest req, ServletResponse res)` --> method yang dipanggil setiap ada request masuk
- Salah satu class turunan Servlet yang banyak digunakan `HttpServlet`.
- Saat membuat class Servlet, perlu meregistrasikan class tersebut ke Java Web dengan menambahkan Annotation `@WebServlet("/path")` pada class Servlet nya.

## Deploy War File
- Hapus plugin `spring-boot-maven-plugin` di pom.xml jika ada, karena plugin tersebut membutuhkan main class.
- `mvn clean package` membuat War file, akan masuk di folder target, kemudian rename agar lebih mudah.
- Pindahkan War file ke folder `webapps` di Apache Tomcat, secara otomatis Apache Tomcat akan mendeteksi file baru dan mengekstraknya menjadi sebuah folder.
- untuk mengaksesnya dengan `http://localhost:8080/nama-folder-atau-war-file-nya`
- untuk Undeploy, cukup hapus folder dan War filenya di webapps

## Learning
- main/HelloServlet.java
- main/MainApp.java
- main/UnsafeServlet.java
- main/CounterServlet.java
- main/HttpMethodServlet.java
- main/RequestServlet.java
- main/ResponseBodyServlet.java
- main/JsonServlet.java
- main/StatusCodeServlet.java
- main/RequestParamServlet.java
- main/RequestHeaderServet.java
- main/RequestFormServet.java
