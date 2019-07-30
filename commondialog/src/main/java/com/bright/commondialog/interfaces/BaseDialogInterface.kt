package com.bright.commondialog.interfaces
import android.app.Dialog
import com.bright.commondialog.base.BaseDialogBuilder

interface BaseDialogInterface {
    fun show(baseDialogBuilder: BaseDialogBuilder<*, *>): Dialog?

    fun dismissDialog()

    fun dialogIsShow(): Boolean

    fun cancelDialog()
}