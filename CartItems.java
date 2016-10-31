package Servion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class CartItems 
{
	public static List<ItemBean> cart=new ArrayList<>();
	public static CartItems object;
	private CartItems() {}
	
	
	public void addItem(ItemBean iBean)
	{

		Iterator<ItemBean> iterator=cart.iterator();
		boolean exist=false;
		while(iterator.hasNext())
		{
			ItemBean obj=(ItemBean) iterator.next();
			if(obj.getId()==(iBean.getId()))
			{
				exist=true;
			}
		}
		if(!exist)
		{
			cart.add(iBean);
			
		}
	}
	
	
	public void removeItem(ItemBean iBean)
	{
		ItemBean removeItem=null;
		Iterator<ItemBean> iterator=cart.iterator();
		while(iterator.hasNext())
		{
			ItemBean obj=(ItemBean) iterator.next();
			if(obj.getId()==(iBean.getId()))
			{
				removeItem=obj;
			}
		}
		cart.remove(removeItem);
		
	}
	
	
	public synchronized static CartItems getInstance()
	{
		if(object==null)
		{
			object=new CartItems();
		}
		return object;
	}
	
	public static List<ItemBean> getList()
	{
		return cart;
	}

	public void remove() 
	{
		cart.clear();
	}
	public synchronized static int TotalPrice()
	{
		int total=0;
		Iterator<ItemBean> iterator=cart.iterator();
		while (iterator.hasNext())
		{
			ItemBean itemBean = (ItemBean) iterator.next();
			total=total+Integer.valueOf(itemBean.getPrice());
		}
		return total;
	}


	public synchronized static int Tax() 
	{
		return TotalPrice()/100 *14;
	}


	public synchronized static int Bill() {
		return TotalPrice()+Tax();
	}
	
	
}
