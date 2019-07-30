package com.bright.commondialog.interfaces

import android.app.Dialog
import android.view.View

interface OnDialogClickedListener {
    fun onClick(view: View, dialog: Dialog)
    fun onClick(view: View, dialog: Dialog, data: Any?)
}