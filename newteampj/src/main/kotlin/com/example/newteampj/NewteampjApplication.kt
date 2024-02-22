package com.example.newteampj

import org.apache.tomcat.util.http.fileupload.FileUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.net.URL

@SpringBootApplication
class NewteampjApplication

fun main(args: Array<String>) {

    FileUtils.copyURLToFile(
        soruce = URL("{http://data.seoul.go.kr/dataList/OA-2256/S/1/datasetView.do}"),
        destination = File("{destination-file-path}"),
        connectionTimeout = 5000,
        readTimeout = 10000)
//이 코드가 csv파일을 읽어오는 코드로 찾아온건데 이걸 작동시키려면 어디에 넣고 어떤 코드가 더 필요할지 모르겠습니다
    runApplication<NewteampjApplication>(*args)


}
