package com.example.bottomsheetdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
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
        setContentView(R.layout.activity_main)

        val btnModalSheet = findViewById<Button>(R.id.btnShowModalBottomSheet)
        btnModalSheet.setOnClickListener {
            showModalBottomSheet()
        }


        /*
* STATE_COLLAPSED: The bottom sheet is visible but only showing its peek height. This state is usually the ‘resting position’ of a Bottom Sheet.
* STATE_EXPANDED: The bottom sheet is visible and its maximum height and it is neither dragging nor settling
* STATE_DRAGGING: The user is actively dragging the bottom sheet up or down.
* STATE_HIDDEN: The bottom sheet is no longer visible.
  */

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