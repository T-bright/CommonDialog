package com.bright.commondialog.base

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.annotation.FloatRange
import androidx.annotation.StringRes
import com.bright.commondialog.interfaces.BaseDialogInterface
import com.bright.commondialog.interfaces.OnDialogClickedListener


abstract class BaseDialogBuilder<B, D : BaseDialogInterface>(var context: Context, var style: Int) {

    //初始化 Builder
    abstract var dialogBuilder: B

    //初始化Dialog
    abstract fun build(): D

    open var dialog: D? = null

    //标题
    open var title: String? = null
    //消息
    open var message: String? = null
    //dialog宽度
    open var width = WindowManager.LayoutParams.MATCH_PARENT
    //dialog高度
    open var height = WindowManager.LayoutParams.WRAP_CONTENT
    open var gravity = Gravity.CENTER

    open var isCancelable = true//点击空白区域是否消失。默认消失

    open var animStyle = 0//进入退出动画

    open var dimAmount = 1.1f //背景昏暗度

    //positive按钮。一般是右边的确定按钮。这个用户自定义。
    open var positiveStr: String? = null
    open var onPositiveDialogClickedListener: OnDialogClickedListener? = null

    //negative按钮。一般是左边的取消按钮。这个用户自定义。
    open var negativeStr: String? = null
    open var onNegativeDialogClickedListener: OnDialogClickedListener? = null

    open fun show(): D {
        if (dialog == null) {
            dialog = build()
        }
        dialog!!.show(this)
        return dialog!!
    }

    //设置标题
    open fun withTitle(title: String?): B {
        this.title = title
        return dialogBuilder
    }

    //设置标题
    open fun withTitle(@StringRes title: Int): B {
        this.title = context.getString(title)
        return dialogBuilder
    }

    //设置消息
    open fun withMessage(@StringRes message: Int): B {
        this.message = context.getString(message)
        return dialogBuilder
    }

    //设置消息
    open fun withMessage(message: String): B {
        this.message = message
        return dialogBuilder
    }

    open fun withCanCancel(canCancel: Boolean): B {
        this.isCancelable = canCancel
        return dialogBuilder
    }

    open fun withWidth(width: Int): B {
        this.width = width
        return dialogBuilder
    }

    open fun withHeight(height: Int): B {
        this.height = height
        return dialogBuilder
    }

    open fun withGravity(gravity: Int): B {
        this.gravity = gravity
        return dialogBuilder
    }

    //设置动画
    open fun withAnimStyle(animStyle: Int): B {
        this.animStyle = animStyle
        return dialogBuilder
    }

    //设置背景昏暗度
    open fun withDimAmount(@FloatRange(from = 0.0, to = 1.0) dimAmount: Float): B {
        this.dimAmount = dimAmount
        return dialogBuilder
    }

    open fun withPositive(positiveStr: String = "", onPositiveClicked: (view: View, dialog: Dialog) -> Unit?): B {
        this.positiveStr = positiveStr
        this.onPositiveDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {
            }

            override fun onClick(view: View, dialog: Dialog) {
                onPositiveClicked(view, dialog)
            }
        }
        return dialogBuilder
    }

    open fun withPositive(positiveStr: String = "", onPositiveClicked: (view: View, dialog: Dialog, data: Any?) -> Unit?): B {
        this.positiveStr = positiveStr
        this.onPositiveDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {
                onPositiveClicked(view, dialog, data)
            }

            override fun onClick(view: View, dialog: Dialog) {
            }
        }
        return dialogBuilder
    }

    open fun withPositive(@StringRes positiveStr: Int, onPositiveClicked: (view: View, dialog: Dialog) -> Unit?): B {
        this.positiveStr = context.getString(positiveStr)
        this.onPositiveDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {

            }

            override fun onClick(view: View, dialog: Dialog) {
                onPositiveClicked(view, dialog)
            }
        }
        return dialogBuilder
    }

    open fun withPositive(@StringRes positiveStr: Int, onPositiveClicked: (view: View, dialog: Dialog, data: Any?) -> Unit?): B {
        this.positiveStr = context.getString(positiveStr)
        this.onPositiveDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {
                onPositiveClicked(view, dialog, data)
            }

            override fun onClick(view: View, dialog: Dialog) {

            }
        }
        return dialogBuilder
    }

    open fun withNegative(negativeStr: String = "", onNegativeClicked: (view: View, dialog: Dialog) -> Unit?): B {
        this.negativeStr = negativeStr
        this.onNegativeDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {

            }

            override fun onClick(view: View, dialog: Dialog) {
                onNegativeClicked(view, dialog)
            }
        }
        return dialogBuilder
    }

    open fun withNegative(negativeStr: String = "", onNegativeClicked: (view: View, dialog: Dialog, data: Any?) -> Unit?): B {
        this.negativeStr = negativeStr
        this.onNegativeDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {
                onNegativeClicked(view, dialog, data)
            }

            override fun onClick(view: View, dialog: Dialog) {

            }
        }
        return dialogBuilder
    }

    open fun withNegative(@StringRes negativeStr: Int, onNegativeClicked: (view: View, dialog: Dialog) -> Unit?): B {
        this.negativeStr = context.getString(negativeStr)
        this.onNegativeDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {

            }

            override fun onClick(view: View, dialog: Dialog) {
                onNegativeClicked(view, dialog)
            }
        }
        return dialogBuilder
    }

    open fun withNegative(@StringRes negativeStr: Int, onNegativeClicked: (view: View, dialog: Dialog, data: Any?) -> Unit?): B {
        this.negativeStr = context.getString(negativeStr)
        this.onNegativeDialogClickedListener = object : OnDialogClickedListener {
            override fun onClick(view: View, dialog: Dialog, data: Any?) {
                onNegativeClicked(view, dialog, data)
            }

            override fun onClick(view: View, dialog: Dialog) {

            }
        }
        return dialogBuilder
    }

    open fun destroy() {
        onNegativeDialogClickedListener = null
        onPositiveDialogClickedListener = null
        if (dialog != null) {
            if (dialog!!.dialogIsShow()) {
                dialog!!.dismissDialog()
            }
            dialog!!.cancelDialog()
            dialog = null
        }
    }
}