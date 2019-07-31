# CommonDialog
CommonDialog是一个基于AlertDialog的封装，支持弹出动画。<br/>
这个库的主要作用就是封装了一个AlertDialog的基类。<br/>
大家可以根据自己实际项目的需要，仿照CommonDialog实现一个。<br/>

# 预览效果

# 如何使用
```
 CommonDialogBuilder(this).withType(CommonDialogBuilder.HAVETITLE_ONLY)
            .withTitle("标题")
            .withMessage("这是展示的消息体")
            .withNegative("取消") { view, dialog ->
                toast("取消")
            }
            .withPositive("确定") { view, dialog ->
                dialog.dismiss()
                toast("确定")
            }
            .show()
```