package monster.sasakisan.exoplayer_recyclerview_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import monster.sasakisan.exoplayer_recyclerview_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false).apply {
                val divider = DividerItemDecoration(context, orientation)
                addItemDecoration(divider)
            }
            layoutManager = linearLayoutManager
            val list = ArrayList<Group>()
            for (i in 0..10) {
                list.add(PlayerItem(context))
            }
            this@MainActivity.adapter.update(list)
        }
    }
}
