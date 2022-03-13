import android.view.View
import android.view.ViewGroup
import androidx.core.view.*

object EdgeToEdge {
    @Suppress("DEPRECATION") //Non-deprecated options are only available api 29+
    fun fixPadding(
        view: View?,
        left: Boolean = false,
        top: Boolean = false,
        right: Boolean = false,
        bottom: Boolean = false
    ) {
        if (view == null) return
        view.run {
            val (initialLeft, initialTop, initialRight, initialBottom) =
                listOf(paddingLeft, paddingTop, paddingRight, paddingBottom)

            ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
                view.updatePadding(
                    left = initialLeft + (if (left) insets.systemWindowInsetLeft else 0),
                    top = initialTop + (if (top) insets.systemWindowInsetTop else 0),
                    right = initialRight + (if (right) insets.systemWindowInsetRight else 0),
                    bottom = initialBottom + (if (bottom) insets.systemWindowInsetBottom else 0)
                )

                insets
            }
        }
    }

    @Suppress("DEPRECATION") //Non-deprecated options are only available api 29+
    fun fixMargin(
        view: View?,
        left: Boolean = false,
        top: Boolean = false,
        right: Boolean = false,
        bottom: Boolean = false
    ) {
        if (view == null) return
        view.run {
            val (initialLeft, initialTop, initialRight, initialBottom) =
                listOf(marginLeft, marginTop, marginRight, marginBottom)

            ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
                view.updateLayoutParams {
                    (this as? ViewGroup.MarginLayoutParams)?.let {
                        updateMargins(
                            left = initialLeft + (if (left) insets.systemWindowInsetLeft else 0),
                            top = initialTop + (if (top) insets.systemWindowInsetTop else 0),
                            right = initialRight + (if (right) insets.systemWindowInsetRight else 0),
                            bottom = initialBottom + (if (bottom) insets.systemWindowInsetBottom else 0)
                        )
                    }
                }

                insets
            }
        }
    }
}
