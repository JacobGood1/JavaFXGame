import javafx.animation.Transition
import javafx.scene.image.ImageView
import javafx.util.Duration
import javafx.animation.Interpolator
import javafx.geometry.Rectangle2D

class SpriteAnimation extends Transition
{
	
	ImageView imageView
    int count
    int columns
    int offsetX
    int offsetY
    int width
    int height

    int lastIndex

    new(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height) 
    {
        this.imageView = imageView
        this.count     = count
        this.columns   = columns
        this.offsetX   = offsetX
        this.offsetY   = offsetY
        this.width     = width
        this.height    = height
        setCycleDuration(duration)
        setInterpolator(Interpolator::LINEAR)
    }

    override void interpolate(double k) 
    {
        val index = Math::min(Math::floor(k * count), count - 1).intValue
        if (index != lastIndex) 
        {
            val x = (index % columns).intValue * width  + offsetX
            val y = (index / columns).intValue * height + offsetY
            imageView.setViewport(new Rectangle2D(x, y, width, height))
            lastIndex = index.intValue
        }
    }
}
