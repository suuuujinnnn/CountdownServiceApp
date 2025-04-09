import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            val input = et_countdown.text.toString().toIntOrNull()
            if (input != null && input > 0) {
                val intent = Intent(this, CountdownService::class.java).apply {
                    putExtra("COUNTDOWN_VALUE", input)
                }
                startService(intent)
            } else {
                Toast.makeText(this, "Please enter a valid number!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}