package com.fitareq.barikoiassignment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup.LayoutParams
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private var dialog: Dialog? = null
    fun showLoadingScreen() {
        if (dialog == null) {
            dialog = Dialog(this)
            dialog?.apply {
                setContentView(ProgressBar(this@BaseActivity))
                window?.apply {
                    setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                }
                setCancelable(false)

            }
        }
        dialog!!.show()
    }

    fun hideLoadingScreen() {
        dialog?.dismiss()
    }
}