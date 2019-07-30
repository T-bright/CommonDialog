package com.bright.commondialog.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bright.commondialog.R
import com.bright.commondialog.interfaces.BaseDialogInterface

abstract class BaseDialog<T : BaseDialogBuilder<*, *>>(context: Context, style: Int = R.style.BaseDialog) : AlertDialog(context, style), BaseDialogInterface {

    open lateinit var dialogBuilder: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
        initDialog()
        bindView(savedInstanceState)
    }

    open fun initDialog() {
        window?.let {
            var params = it.attributes
            params.gravity = dialogBuilder.gravity
            params.width = dialogBuilder.width
            params.height = dialogBuilder.height
            if (dialogBuilder.animStyle != 0) it.setWindowAnimations(dialogBuilder.animStyle)
            if (dialogBuilder.dimAmount in 0.0..1.0) params.dimAmount = dialogBuilder.dimAmount
            it.attributes = params
        }
    }

    abstract fun bindView(saveInstanceState: Bundle?)

    abstract fun setContentView(): Int

    @Suppress("UNCHECKED_CAST")
    override fun show(baseDialogBuilder: BaseDialogBuilder<*, *>): Dialog? {
        this.dialogBuilder = baseDialogBuilder as T
        this.setCanceledOnTouchOutside(baseDialogBuilder.isCancelable)
        this.show()
        return this
    }

    override fun dismissDialog() {
        this.dismiss()
    }

    override fun dialogIsShow(): Boolean {
        return isShowing
    }

    override fun cancelDialog() {
        this.cancel()
    }
}