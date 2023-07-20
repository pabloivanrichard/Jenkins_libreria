def apimessageSender(String urls, String message) {
  /*
    def http = new URL(url).openConnection()
    http.setRequestMethod("POST")
    http.setRequestProperty("Content-Type", "application/json")
    http.setDoOutput(true)
    
    def data = message
    
    http.getOutputStream().withCloseable { os ->
        os.write(data.toString().getBytes("UTF-8"))
        os.flush()
    }
    
    def response = http.getResponseCode()
    println("API Response: $response")
*/
    def url = new URL(urls)
    def conn = url.openConnection()
    conn.setDoOutput(true)
    def writer = new OutputStreamWriter(conn.getOutputStream())

    writer.write(message)
    writer.flush()
    String line
    def reader = new BufferedReader(new     InputStreamReader(conn.getInputStream()))
    while ((line = reader.readLine()) != null) {
      println line
    }
    writer.close()
    reader.close()




}