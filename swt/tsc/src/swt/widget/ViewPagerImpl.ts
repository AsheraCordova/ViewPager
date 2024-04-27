// start - imports

	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';
import { Mixin, decorate } from 'ts-mixer';












import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class ViewPagerImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "currentItem" }))
	currentItem!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "offscreenPageLimit" }))
	offscreenPageLimit!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "pageMargin" }))
	pageMargin!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "pageMarginDrawable" }))
	pageMarginDrawable!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onPageScrolled" }))
	onPageScrolled!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onPageSelected" }))
	onPageSelected!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onPageScrollStateChange" }))
	onPageScrollStateChange!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "pageWidth" }))
	pageWidth!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "pageTitles" }))
	pageTitles!:CommandAttr<string>| undefined;

	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.currentItem = undefined;
		this.offscreenPageLimit = undefined;
		this.pageMargin = undefined;
		this.pageMarginDrawable = undefined;
		this.onPageScrolled = undefined;
		this.onPageSelected = undefined;
		this.onPageScrollStateChange = undefined;
		this.pageWidth = undefined;
		this.pageTitles = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setCurrentItem(value : number) : T {
		this.resetIfRequired();
		if (this.currentItem == null || this.currentItem == undefined) {
			this.currentItem = new CommandAttr<number>();
		}
		
		this.currentItem.setSetter(true);
		this.currentItem.setValue(value);
		this.orderSet++;
		this.currentItem.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOffscreenPageLimit(value : number) : T {
		this.resetIfRequired();
		if (this.offscreenPageLimit == null || this.offscreenPageLimit == undefined) {
			this.offscreenPageLimit = new CommandAttr<number>();
		}
		
		this.offscreenPageLimit.setSetter(true);
		this.offscreenPageLimit.setValue(value);
		this.orderSet++;
		this.offscreenPageLimit.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPageMargin(value : string) : T {
		this.resetIfRequired();
		if (this.pageMargin == null || this.pageMargin == undefined) {
			this.pageMargin = new CommandAttr<string>();
		}
		
		this.pageMargin.setSetter(true);
		this.pageMargin.setValue(value);
		this.orderSet++;
		this.pageMargin.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPageMarginDrawable(value : string) : T {
		this.resetIfRequired();
		if (this.pageMarginDrawable == null || this.pageMarginDrawable == undefined) {
			this.pageMarginDrawable = new CommandAttr<string>();
		}
		
		this.pageMarginDrawable.setSetter(true);
		this.pageMarginDrawable.setValue(value);
		this.orderSet++;
		this.pageMarginDrawable.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnPageScrolled(value : string) : T {
		this.resetIfRequired();
		if (this.onPageScrolled == null || this.onPageScrolled == undefined) {
			this.onPageScrolled = new CommandAttr<string>();
		}
		
		this.onPageScrolled.setSetter(true);
		this.onPageScrolled.setValue(value);
		this.orderSet++;
		this.onPageScrolled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnPageSelected(value : string) : T {
		this.resetIfRequired();
		if (this.onPageSelected == null || this.onPageSelected == undefined) {
			this.onPageSelected = new CommandAttr<string>();
		}
		
		this.onPageSelected.setSetter(true);
		this.onPageSelected.setValue(value);
		this.orderSet++;
		this.onPageSelected.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnPageScrollStateChange(value : string) : T {
		this.resetIfRequired();
		if (this.onPageScrollStateChange == null || this.onPageScrollStateChange == undefined) {
			this.onPageScrollStateChange = new CommandAttr<string>();
		}
		
		this.onPageScrollStateChange.setSetter(true);
		this.onPageScrollStateChange.setValue(value);
		this.orderSet++;
		this.onPageScrollStateChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPageWidth(value : number) : T {
		this.resetIfRequired();
		if (this.pageWidth == null || this.pageWidth == undefined) {
			this.pageWidth = new CommandAttr<number>();
		}
		
		this.pageWidth.setSetter(true);
		this.pageWidth.setValue(value);
		this.orderSet++;
		this.pageWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setPageTitles(value : string) : T {
		this.resetIfRequired();
		if (this.pageTitles == null || this.pageTitles == undefined) {
			this.pageTitles = new CommandAttr<string>();
		}
		
		this.pageTitles.setSetter(true);
		this.pageTitles.setValue(value);
		this.orderSet++;
		this.pageTitles.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit
export abstract class ViewPagerImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "layout_gravity" }))
	layout_gravity!:CommandAttr<Gravity[]>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "layout_isdecor" }))
	layout_isdecor!:CommandAttr<boolean>| undefined;
	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_gravity = undefined;
		this.layout_isdecor = undefined;
		return this.thisPointer;
	}
	constructor() {
		super();
		this.thisPointer = this.getThisPointer();
	}
	
	public setLayoutGravity(...value : Gravity[]) : T {
		if (this.layout_gravity == null || this.layout_gravity == undefined) {
			this.layout_gravity = new CommandAttr<Gravity[]>();
		}
		this.layout_gravity.setSetter(true);
		this.layout_gravity.setValue(value);
		this.orderSet++;
		this.layout_gravity.setOrderSet(this.orderSet);
this.layout_gravity.setTransformer('gravity');		return this.thisPointer;
	}
	public setLayoutIsdecor(value : boolean) : T {
		if (this.layout_isdecor == null || this.layout_isdecor == undefined) {
			this.layout_isdecor = new CommandAttr<boolean>();
		}
		this.layout_isdecor.setSetter(true);
		this.layout_isdecor.setValue(value);
		this.orderSet++;
		this.layout_isdecor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
}

export class ViewPager_LayoutParams extends ViewPagerImpl_LayoutParams<ViewPager_LayoutParams> implements ILayoutParam {
    getThisPointer(): ViewPager_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class ViewPager extends ViewPagerImpl<ViewPager> implements IWidget{
    getThisPointer(): ViewPager {
        return this;
    }
    
   	public getClass() {
		return ViewPager;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

ViewPagerImpl.initialize();
export interface OnPageScrolledEvent extends Event{
	        position:number;
	        positionOffset:number;
	        positionOffsetPixels:number;

}
export interface OnPageSelectedEvent extends Event{
	        position:number;

}
export interface OnPageScrollStateChangedEvent extends Event{
	        state:number;

}
export interface OnPageScrolledEvent extends Event{
	        position:number;
	        positionOffset:number;
	        positionOffsetPixels:number;

}
export interface OnPageSelectedEvent extends Event{
	        position:number;

}
export interface OnPageScrollStateChangedEvent extends Event{
	        state:number;

}
export interface OnPageScrolledEvent extends Event{
	        position:number;
	        positionOffset:number;
	        positionOffsetPixels:number;

}
export interface OnPageSelectedEvent extends Event{
	        position:number;

}
export interface OnPageScrollStateChangedEvent extends Event{
	        state:number;

}

//end - staticinit
