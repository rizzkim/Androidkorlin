package com.example.androidkorlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_basic_widjet.*

class BasicWidjet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_widjet)

        val text : String = edit1.text.toString()

        //3글자 이상 입력할 수 없도록 설정
        edit1.setFilters(
            arrayOf<InputFilter>(
                InputFilter.LengthFilter(3)
            )
        )

        //버튼을 누르면 키보드 숨기기
        hideBtn.setOnClickListener({
            //키보드 관리 객체 생성
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //edit1의 키보드 제어권 뺏기
            imm.hideSoftInputFromWindow(edit1.windowToken, 0)
        })
        //버튼을 누르면 키보드 출력
        showBtn.setOnClickListener({
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //edit1에 입력하는 키보드를 화면에 출력
            imm.showSoftInput(edit1, 0)
        })
    }
}