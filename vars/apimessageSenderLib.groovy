def apimessageSender(String url, String message) {
    def http = new URL(url).openConnection()
    http.setRequestMethod("POST")
    http.setRequestProperty("Content-Type", "application/json")
    http.setDoOutput(true)
    
    def data = [message: message] as JSON
    
    http.getOutputStream().withCloseable { os ->
        os.write(data.toString().getBytes("UTF-8"))
        os.flush()
    }
    
    def response = http.getResponseCode()
    println("API Response: $response")
}