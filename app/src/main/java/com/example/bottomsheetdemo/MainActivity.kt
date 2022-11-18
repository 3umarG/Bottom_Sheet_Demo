package com.example.bottomsheetdemo

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior

/*
TODO:
* 1- Bottom Sheet Background (color , corners , ...)
* 2- Bottom Sheet Layout
* 3- Programmatically
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnShowButtomSheet)

        btn.setOnClickListener {
            BottomSheetBehavior.from(findViewById(R.id.bottomSheetStandard)).apply {
                this.state = BottomSheetBehavior.STATE_COLLAPSED
            }
//            showBottomSheet()
        }

        BottomSheetBehavior.from(findViewById(R.id.bottomSheetStandard)).apply {
            this.state = BottomSheetBehavior.STATE_HIDDEN
            /*
       * STATE_COLLAPSED: The bottom sheet is visible but only showing its peek height. This state is usually the ‘resting position’ of a Bottom Sheet.
       * STATE_EXPANDED: The bottom sheet is visible and its maximum height and it is neither dragging nor settling
       * STATE_DRAGGING: The user is actively dragging the bottom sheet up or down.
       * STATE_HIDDEN: The bottom sheet is no longer visible.
             */
        }
    }

    private fun showBottomSheet() {
        // Setup the bottom sheet as a dialogue
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_layout)


        val createLayout = dialog.findViewById<LinearLayout>(R.id.createLayout)
        val deleteLayout = dialog.findViewById<LinearLayout>(R.id.deleteLayout)
        val exitLayout = dialog.findViewById<LinearLayout>(R.id.exitLayout)

        createLayout.setOnClickListener {
            onItemDialogListener(dialog, "Created")
        }

        deleteLayout.setOnClickListener {
            onItemDialogListener(dialog, "Deleted")
        }

        exitLayout.setOnClickListener {
            onItemDialogListener(dialog, "Exit!!")
        }

        dialog.apply {
            show()
            window?.apply {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                attributes.windowAnimations = R.style.BottomSheetTheme
                setGravity(Gravity.BOTTOM)

            }
        }


    }

    private fun onItemDialogListener(dialog: Dialog, mess: String) {
        dialog.dismiss()
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
    }


}