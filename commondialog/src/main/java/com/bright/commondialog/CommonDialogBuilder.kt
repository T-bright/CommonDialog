package com.bright.commondialog

import android.content.Context
import android.text.TextUtils
import androidx.annotation.StringRes
import com.bright.commondialog.base.BaseDialogBuilder


class CommonDialogBuilder(private var context: Context, private var style: Int = R.style.BaseDialog) : BaseDialogBuilder<CommonDialogBuilder, CommonDialog>(context, style) {

    companion object {
        const val NOTITLE_ONLY = "1"//没有标题，但是有两个按钮
        const val NOTITLE_ONLY_HAVE_ONEBUTTON = "2"//没有标题，下面只有一个按钮
        const val HAVETITLE_ONLY = "3"//有标题，但是有两个按钮
        const val HAVETITLE_ONLY_HAVE_ONEBUTTON = "4"//有标题，下面只有一个按钮
        const val HAVETITLE_INPUT = "5"//有标题，有两个按钮,有输入框
    }

    override var dialogBuilder: CommonDialogBuilder = this

    override fun dialogInstance(): CommonDialog {
        return CommonDialog(context)
    }

    //类型
    var type: String? = NOTITLE_ONLY

    //输入框的hint字符
    var inputHint: String? = null
    //输入框的字符
    var inputText: String? = null

    //一个按钮时的  知道了 按钮
    open var getItStr: String? = null

    //Dialog需要的处理的数据
    open var data: Any? = null

    fun withInputHint(inputHint: String?): CommonDialogBuilder {
        this.inputHint = inputHint
        return this
    }

    fun withInputHint(@StringRes inputHint: Int): CommonDialogBuilder {
        this.inputHint = context.getString(inputHint)
        return this
    }

    fun withInputText(inputText: String?): CommonDialogBuilder {
        this.inputText = inputText
        return this
    }

    fun withInputTextt(@StringRes inputText: Int): CommonDialogBuilder {
        this.inputText = context.getString(inputText)
        return this
    }

    fun withType(type: String?): CommonDialogBuilder {
        if (!TextUtils.isEmpty(type)) {
            this.type = type
        }
        return this
    }

    fun withGetIt(getItStr: String?): CommonDialogBuilder {
        this.getItStr = getItStr
        return this
    }

    fun withGetIt(@StringRes getItStr: Int): CommonDialogBuilder {
        this.getItStr = context.getString(getItStr)
        return this
    }

    fun withDialogBean(data: Any): CommonDialogBuilder {
        this.data = data
        return this
    }
}