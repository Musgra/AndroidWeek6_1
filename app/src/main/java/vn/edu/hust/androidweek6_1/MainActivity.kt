package vn.edu.hust.androidweek6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<ItemModel>()

        val emailPrefixes = listOf(
            "john.doe", "jane.smith", "alice.jones", "bob.wilson", "emma.brown",
            "david.white", "lisa.anderson", "william.clark", "susan.martin", "michael.hall"
        )

        val subjects = listOf(
            "Chúc mừng bạn!",
            "Thông báo quan trọng",
            "Cảm ơn bạn đã đăng ký",
            "Thông báo về tài khoản của bạn",
            "Những tin tức mới nhất"
        )

        val contentTemplates = listOf(
            "Chào bạn, chúng tôi rất vui thông báo rằng tài khoản của bạn đã được kích hoạt.",
            "Xin chào, bạn có một thông báo quan trọng về tài khoản của bạn.",
            "Cảm ơn bạn đã đăng ký và tham gia cùng chúng tôi!",
            "Tài khoản của bạn đã được cập nhật. Vui lòng kiểm tra chi tiết.",
            "Chào bạn, dưới đây là những tin tức mới nhất mà bạn không nên bỏ lỡ."
        )

        val random = Random()

        for (i in 1..17) {
            val email = "${emailPrefixes[random.nextInt(emailPrefixes.size)]}$i@gmail.com"
            val subject = subjects[random.nextInt(subjects.size)]
            val content = contentTemplates[random.nextInt(contentTemplates.size)]

            val hour = random.nextInt(12) + 1
            val minute = random.nextInt(60)
            val period = if (random.nextBoolean()) "AM" else "PM"

            val time = String.format("%02d:%02d %s", hour, minute, period)

            itemList.add(ItemModel(email, subject, content, time))
        }

        val adapter = ItemAdapter(itemList)
        val listView = findViewById<RecyclerView>(R.id.listView)
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = adapter
    }
}