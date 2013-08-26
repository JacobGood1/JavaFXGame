import org.eclipse.xtext.xbase.lib.Inline;


public class ObjectFiller 
{
	@Inline("new Player(_gameSurface, _gameNodes, _spriteManager, _utilities, _assets)")
	public static Player n(Class<Player> name)
	{
		throw new UnsupportedOperationException();
	}
}
