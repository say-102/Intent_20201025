package kr.co.tjoeun.intent_20201025

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {

//    클래스 정의부분 바로 빝에 적는(만드는) 변수 : 멤버변수
//    fun 안에서 적는(만드는) 변수 : 지역변수 - Local변수

//
    val REQ_FOR_DATA = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherActivityBtn.setOnClickListener {

//            다른 화면 (마이퍼스트엑티비티) 으로 이동

            val myIntent = Intent(this, MyFirstActivity::class.java)
            startActivity(myIntent)

        }

        sendDataBtn.setOnClickListener {

//            다른 화면 (마이세컨드엑티비티) 으로 이동
//            가는길에 데이터 (입력한 내용)를 들고 이동.

            val inputcontent = contentEdt.text.toString()

            val myIntent = Intent(this, MySecondActivity::class.java)
            myIntent.putExtra("content", inputcontent)
            startActivity(myIntent)

        }

        changeTextBtn.setOnClickListener {
            val myIntent = Intent(this, EditDataActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_DATA)

        }

//        전화 걸기 예제 (DIAL)

        dialBtn.setOnClickListener {

//            전화를 어디에(입력값추출) 연결할지, 연결 정보(uri)를 변수에 저장.
            val inputPhoneNum = phoneEdt.text.toString()
//            tel: + 입력한폰번 = "tel:%{입력한폰번}"
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            어느 화면으로 이동할지? Intent
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)


        callBtn.setOnClickListener {
            val inputPhoneNum = phoneEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }


        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "ㅇㅇㅇ")
            startActivity(myIntent)
//            문자에 미리 내용을 담아두고 싶다! => 화면을 넘어갈때, 보여줄 문구를 담아주자!
//            => putExtra 활용 (안드로이드팀이 정해둔 데이터이름표 : "sms_body")

        }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_DATA) {

            if (resultCode == Activity.RESULT_OK) {

                val newInputData = data?.getStringExtra("newData")
                dataTxt.text = newInputData

            }

        }
    }

}