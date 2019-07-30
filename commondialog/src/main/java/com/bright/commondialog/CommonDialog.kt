package com.bright.commondialog

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import com.bright.commondialog.base.BaseDialog
import com.bright.commondialog.extension.gone
import com.bright.commondialog.extension.visible
import kotlinx.android.synthetic.main.dialog_common.*


class CommonDialog(context: Context, style: Int) : BaseDialog<CommonDialogBuilder>(context, style) {

    override fun setContentView(): Int {
        return R.layout.dialog_common
    }

    override fun bindView(saveInstanceState: Bundle?) {
        initVisible()
        initListener()
    }

    override fun onStart() {
        super.onStart()
        initData()
    }

    private fun initData() {
        if (!TextUtils.isEmpty(dialogBuilder.title)) title.text = dialogBuilder.title else title.text = ""

        if (!TextUtils.isEmpty(dialogBuilder.message)) message.text = dialogBuilder.message else message.text = ""

        if (!TextUtils.isEmpty(dialogBuilder.inputHint)) et_input.hint = dialogBuilder.inputHint else et_input.hint = ""

        if (!TextUtils.isEmpty(dialogBuilder.inputText)) et_input.setText(dialogBuilder.inputText) else et_input.setText("")

        if (!TextUtils.isEmpty(dialogBuilder.negativeStr)) cancel.text = dialogBuilder.negativeStr else cancel.text = "取消"

        if (!TextUtils.isEmpty(dialogBuilder.positiveStr)) confirm.text = dialogBuilder.positiveStr else confirm.text = "确定"

        if (!TextUtils.isEmpty(dialogBuilder.getItStr)) get_it.text = dialogBuilder.getItStr else get_it.text = "知道了"
    }


    private fun initVisible() {
        when (dialogBuilder.type) {
            CommonDialogBuilder.HAVETITLE_ONLY -> {
                title.visible()
                have_two_button.visible()
                message.visible()
                get_it.gone()
                et_input.gone()
            }
            CommonDialogBuilder.NOTITLE_ONLY -> {
                title.gone()
                have_two_button.visible()
                message.visible()
                get_it.gone()
                et_input.gone()
            }
            CommonDialogBuilder.NOTITLE_ONLY_HAVE_ONEBUTTON -> {
                title.gone()
                have_two_button.gone()
                message.visible()
                get_it.visible()
                et_input.gone()
            }
            CommonDialogBuilder.HAVETITLE_ONLY_HAVE_ONEBUTTON -> {
                title.visible()
                have_two_button.gone()
                message.visible()
                get_it.visible()
                et_input.gone()
            }
            CommonDialogBuilder.HAVETITLE_INPUT -> {
                title.visible()
                have_two_button.visible()
                message.gone()
                get_it.gone()
                et_input.visible()
            }
        }
    }


    private fun initListener() {
        confirm.setOnClickListener {
            dialogBuilder.onPositiveDialogClickedListener?.let {
                it.onClick(confirm, this)
                setInputData()
                if (dialogBuilder.data != null) {
                    it.onClick(confirm, this, dialogBuilder.data)
                }
            }
        }
        get_it.setOnClickListener {
            dialogBuilder.onPositiveDialogClickedListener?.let {
                it.onClick(get_it, this)
                setInputData()
                if (dialogBuilder.data != null) {
                    it.onClick(get_it, this, dialogBuilder.data)
                }
            }
        }
        cancel.setOnClickListener {
            dialogBuilder.onNegativeDialogClickedListener?.let {
                dialogBuilder.dialog?.dismiss()
                it.onClick(cancel, this)
                setInputData()
                if (dialogBuilder.data != null) {
                    it.onClick(cancel, this, dialogBuilder.data)
                }
            }
        }
    }

    private fun setInputData() {
        var inputStr = et_input.text.toString()
        if (!TextUtils.isEmpty(inputStr)) {
            dialogBuilder.data = inputStr
        }
    }
}