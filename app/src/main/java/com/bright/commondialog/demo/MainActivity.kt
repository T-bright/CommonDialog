package com.bright.commondialog.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bright.commondialog.CommonDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notitle_only.setOnClickListener { notitleOnly() }
        notitle_only_have_onebutton.setOnClickListener { notitleOnlyHaveOnebutton() }
        havetitle_only.setOnClickListener { havetitleOnly() }
        havetitle_only_have_onebutton.setOnClickListener { havetitleOnlyHaveOnebutton() }
        havetitle_input.setOnClickListener { havetitleInput() }
    }


    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    //没有标题，两个按钮
    private fun notitleOnly() {
        val dataBean = TestDialogDataBean()
        CommonDialogBuilder(this).withType(CommonDialogBuilder.NOTITLE_ONLY)
            .withMessage("确定要开枪吗？")
            .withNegative { view, dialog ->
                toast("点击了取消")
            }
            .withPositive { view, dialog, data ->
                dialog.dismiss()
                var testData = data as TestDialogDataBean
                toast(testData.data)
            }
            .withAnimStyle(R.style.dialogAnimation)
            .withDialogBean(dataBean)
            .show()
    }

    //没有标题，只有一个按钮
    private fun notitleOnlyHaveOnebutton() {
        CommonDialogBuilder(this).withType(CommonDialogBuilder.NOTITLE_ONLY_HAVE_ONEBUTTON)
            .withMessage("我要开枪了！！！")
            .withGetIt("我知道了，开吧")
            .withPositive { view, dialog ->
                dialog.dismiss()
                toast("我知道了，开吧")
            }
            .show()
    }

    //有标题，有两个按钮
    private fun havetitleOnly() {
        CommonDialogBuilder(this).withType(CommonDialogBuilder.HAVETITLE_ONLY)
            .withTitle("开枪？")
            .withMessage("你确定要开枪？")
            .withNegative("我不确定") { view, dialog ->
                toast("我不确定")
            }
            .withPositive("我确定") { view, dialog ->
                dialog.dismiss()
                toast("我确定要开枪")
            }
            .show()
    }

    //有标题，只有一个按钮
    private fun havetitleOnlyHaveOnebutton() {
        CommonDialogBuilder(this).withType(CommonDialogBuilder.HAVETITLE_ONLY_HAVE_ONEBUTTON)
            .withTitle("开枪？")
            .withMessage("你确定要开枪？")
            .withPositive("我知道了，开吧") { view, dialog ->
                dialog.dismiss()
                toast("我开枪了")
            }
            .show()
    }

    var flag = true
    //有标题，有两个按钮,有输入框
    private fun havetitleInput() {
        CommonDialogBuilder(this).withType(CommonDialogBuilder.HAVETITLE_INPUT)
            .withTitle("开枪？")
            .withInputText("你确定要开枪？")
            .withNegative("我不确定") { view, dialog ->
                toast("我不确定")
            }
            .withPositive("我确定") { view, dialog, data ->
                dialog.dismiss()
                var str = data as String
                toast(str)
            }
            .show()
    }

}
