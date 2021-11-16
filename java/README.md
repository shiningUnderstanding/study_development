# 입출력 IO

### 보조스트림

보조스트림은 노드스트림과 연결하여 편리한 기능들을 제공해주는 스트림들이다.   
보조스트림 생성시 자신이 연결될 스트림을 생성자의 매개값으로 받는다.    


##### 문자 변환 보조 스트림    
* 바이트 단위의 스트림을 문자 단위 스트림으로 변환 시켜주는 보조 스트림이다.   
    InputStreamReader   

      InputStream is = Systme.in;    
      Reader reader = new InputStreamReader(is);   
      
    OutputStreamWriter   

      FileOutputStream fos = new FileOutputStream("C:/java/io/a.txt");   
      Writer writer = new OutputStreamWriter(fos);    
      
##### 성능 향상 보조 스트림    
* cpu와 메모리 성능이 입출력 작업 간의 성능보다 좋기 때문에 입출력으로 인해 발생하는 병목구간을 줄여주기 위한 보조 스트림   
버퍼를 이용하여 입출력시 버퍼에 데이터를 바로바로 보내고 한번에 데이터를 읽고 씀으로써 성능을 향상 시켜준다.    
    BufferedInputStream & BufferedReader   

      BufferedInputStream bis = new BufferedInputStream(바이트기반입력스트림);   
      BufferedReader br = new BufferedReader(문자기반입력스트림);

    BufferedOutputStream & BufferedWriter

      BufferedOutputStream bos = new BufferedOutputStream(바이트기반출력스티림);
      BufferedWriter bw = new BufferedWriter(문자기반출력스트림);   
      
##### 기본 타입 입출력 보조 스트림
* 바이트 기반의 스트림을 자바의 기본형 형태로 읽고 쓰기가 가능하게 해주는 보조 스트림   
단, 보조 스트림을 이용해 출력한 데이터는 출력한 타입 순서 그대로 읽기를 해야 파일을 제대로 읽을 수 있다.   
ex) 출력이 int -> String -> char 이면 입력할 시에 int -> String -> char 형태로 읽어와야 한다.
이를 이용해 보안에 용이하도록 만들 수 있다.
    DataInputStream & DataOutputStream   

      DataInputStream dis = new DataInputStream(바이트입력스트림);   
      DataOutputStream dos = new DataOutputStream(바이트출력스트림);   
     
     
##### 프린터 보조 스트림
* 
