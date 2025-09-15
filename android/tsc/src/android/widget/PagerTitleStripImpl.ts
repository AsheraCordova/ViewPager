// start - imports

	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';
import { Mixin, decorate } from 'ts-mixer';









// end - imports
import {ViewImpl} from './ViewImpl';
export abstract class PagerTitleStripImpl<T> extends ViewImpl<T>{
	//start - body
	static initialize() {
    }	
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "textSpacing" }))
	textSpacing!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "nonPrimaryAlpha" }))
	nonPrimaryAlpha!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "textColor" }))
	textColor!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "gravity" }))
	gravity!:CommandAttr<Gravity[]>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "textSize" }))
	textSize!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "textAppearance" }))
	textAppearance!:CommandAttr<string>| undefined;

	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.textSpacing = undefined;
		this.nonPrimaryAlpha = undefined;
		this.textColor = undefined;
		this.gravity = undefined;
		this.textSize = undefined;
		this.textAppearance = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setTextSpacing(value : string) : T {
		this.resetIfRequired();
		if (this.textSpacing == null || this.textSpacing == undefined) {
			this.textSpacing = new CommandAttr<string>();
		}
		
		this.textSpacing.setSetter(true);
		this.textSpacing.setValue(value);
		this.orderSet++;
		this.textSpacing.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setNonPrimaryAlpha(value : number) : T {
		this.resetIfRequired();
		if (this.nonPrimaryAlpha == null || this.nonPrimaryAlpha == undefined) {
			this.nonPrimaryAlpha = new CommandAttr<number>();
		}
		
		this.nonPrimaryAlpha.setSetter(true);
		this.nonPrimaryAlpha.setValue(value);
		this.orderSet++;
		this.nonPrimaryAlpha.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextColor(value : string) : T {
		this.resetIfRequired();
		if (this.textColor == null || this.textColor == undefined) {
			this.textColor = new CommandAttr<string>();
		}
		
		this.textColor.setSetter(true);
		this.textColor.setValue(value);
		this.orderSet++;
		this.textColor.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setGravity(...value : Gravity[]) : T {
		this.resetIfRequired();
		if (this.gravity == null || this.gravity == undefined) {
			this.gravity = new CommandAttr<Gravity[]>();
		}
		
		this.gravity.setSetter(true);
		this.gravity.setValue(value);
		this.orderSet++;
		this.gravity.setOrderSet(this.orderSet);
this.gravity.setTransformer('gravity');		return this.thisPointer;
	}
		

	public setTextSize(value : string) : T {
		this.resetIfRequired();
		if (this.textSize == null || this.textSize == undefined) {
			this.textSize = new CommandAttr<string>();
		}
		
		this.textSize.setSetter(true);
		this.textSize.setValue(value);
		this.orderSet++;
		this.textSize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setTextAppearance(value : string) : T {
		this.resetIfRequired();
		if (this.textAppearance == null || this.textAppearance == undefined) {
			this.textAppearance = new CommandAttr<string>();
		}
		
		this.textAppearance.setSetter(true);
		this.textAppearance.setValue(value);
		this.orderSet++;
		this.textAppearance.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class PagerTitleStrip extends PagerTitleStripImpl<PagerTitleStrip> implements IWidget{
    getThisPointer(): PagerTitleStrip {
        return this;
    }
    
   	public getClass() {
		return PagerTitleStrip;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

PagerTitleStripImpl.initialize();

//end - staticinit
