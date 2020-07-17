import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.team4.R
import com.example.team4.login_acticity

class splash_activity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            // Start your app main activity
            startActivity(Intent(this, login_acticity::class.java))
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}