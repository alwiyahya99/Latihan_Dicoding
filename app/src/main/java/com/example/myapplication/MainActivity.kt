package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_with_data_activity)
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        val btnLatihanViewGroup: Button = findViewById(R.id.btn_view_group)
        val btnRecyclerView: Button = findViewById(R.id.btn_RecyclerView)
        val btnParcelabel: Button = findViewById(R.id.btn_Parcelabel)
        btnParcelabel.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnDialPhone.setOnClickListener(this)
        btnLatihanViewGroup.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
//                val moveIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
//                moveIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Alwi Yahya")
//                moveIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 23)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data_activity -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "student")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5.0)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081320173473"
                val dialPhoneInten = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneInten)
            }
            R.id.btn_view_group -> {
                val viewGroupIntent = Intent(this@MainActivity, LatihanViewGroupActivity::class.java)
                startActivity(viewGroupIntent)
            }
            R.id.btn_RecyclerView -> {
                val viewGroupIntent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
                startActivity(viewGroupIntent)
            }
            R.id.btn_Parcelabel -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                val MoveWithObjectActivity = Intent(this@MainActivity, ParcelabelActivity::class.java)
                MoveWithObjectActivity.putExtra(ParcelabelActivity.EXTRA_PERSON, person)
                startActivity(MoveWithObjectActivity)
            }
        }
    }
}