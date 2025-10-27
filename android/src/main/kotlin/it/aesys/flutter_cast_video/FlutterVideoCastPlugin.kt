package it.aesys.flutter_cast_video

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

/** FlutterVideoCastPlugin */
public class FlutterVideoCastPlugin: FlutterPlugin, ActivityAware {
    private lateinit var chromeCastFactory: ChromeCastFactory

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        chromeCastFactory = ChromeCastFactory(flutterPluginBinding.binaryMessenger)
        flutterPluginBinding
            .platformViewRegistry
            .registerViewFactory(
                "ChromeCastButton",
                chromeCastFactory
            )
    }

    // Remove the companion object entirely - it's deprecated and not needed anymore
    // The new embedding (onAttachedToEngine) is sufficient

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {

    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        chromeCastFactory.activity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {

    }

    override fun onDetachedFromActivity() {

    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {

    }
}