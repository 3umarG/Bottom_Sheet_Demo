package com.example.bottomsheetdemo

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/*
TODO:
* 1- Bottom Sheet Background (color , corners , ...)
* 2- Bottom Sheet Layout
* 3- Programmatically
 */

class MainActivity : AppCompatActivity() {
    private lateinit var modalBottomSheetDialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Code for full screen
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnModalSheet = findViewById<Button>(R.id.btnShowModalBottomSheet)
        btnModalSheet.setOnClickListener {
            showModalBottomSheet()
        }


        findViewById<Button>(R.id.btnShowPersistentBottomSheet).setOnClickListener {
            showPersistentBottomSheet()
        }


        /*
* STATE_COLLAPSED: The bottom sheet is visible but only showing its peek height. This state is usually the ‘resting position’ of a Bottom Sheet.
* STATE_EXPANDED: The bottom sheet is visible and its maximum height and it is neither dragging nor settling
* STATE_DRAGGING: The user is actively dragging the bottom sheet up or down.
* STATE_HIDDEN: The bottom sheet is no longer visible.
  */

    }

    private fun showPersistentBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = LayoutInflater.from(this)
            .inflate(R.layout.bottom_sheet_layout,null)
        bottomSheetDialog.setContentView(bottomSheetView)

        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        val layout = bottomSheetDialog.findViewById<ConstraintLayout>(R.id.bottomSheetLayout)
        layout?.let {
            layout.minHeight = Resources.getSystem().displayMetrics.heightPixels
        }

        bottomSheetDialog.show()

    }

    private fun showModalBottomSheet() {
        modalBottomSheetDialog = BottomSheetDialog(this)

        // دي ماسكة  ال bottom sheet
        val sheetView = LayoutInflater.from(applicationContext)
            .inflate(R.layout.bottom_sheet_layout, findViewById(R.id.bottomSheetLayout), false)

        sheetView.findViewById<LinearLayout>(R.id.createLayout).setOnClickListener {
            Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show()
        }
        sheetView.findViewById<LinearLayout>(R.id.deleteLayout).setOnClickListener {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
        }
        sheetView.findViewById<LinearLayout>(R.id.exitLayout).setOnClickListener {
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
        }

        // Link sheet view with bottomSheetDialog
        modalBottomSheetDialog.setContentView(sheetView)
        modalBottomSheetDialog.show()
    }


}