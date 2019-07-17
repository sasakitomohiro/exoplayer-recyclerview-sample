package monster.sasakisan.exoplayer_recyclerview_sample

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.xwray.groupie.databinding.BindableItem
import monster.sasakisan.exoplayer_recyclerview_sample.databinding.ItemPlayerBinding

class PlayerItem(private val context: Context) : BindableItem<ItemPlayerBinding>() {
    private var player: SimpleExoPlayer? = null

    override fun getLayout() = R.layout.item_player

    override fun bind(viewBinding: ItemPlayerBinding, position: Int) {
        val uri = Uri.parse("https://www.radiantmediaplayer.com/media/bbb-360p.mp4")
        val mediaSource = ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory("exoplayer-recyclerview-sample")).createMediaSource(uri)
        player?.playWhenReady = false
        player?.clearVideoSurface()
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(
                DefaultRenderersFactory(context),
                DefaultTrackSelector(),
                DefaultLoadControl()
            )
        }
        player?.let { player ->
            viewBinding.playerView.player = player
            player.prepare(mediaSource)
            player.playWhenReady = true
            player.seekTo(0)
            player.repeatMode = Player.REPEAT_MODE_OFF
        }
    }
}