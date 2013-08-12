package ninjapancakes87.civilwar.block.cannon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Cannon2 extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
  
  public Cannon2()
  {
    textureWidth = 96;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 1, 1);
      Shape1.setRotationPoint(-8F, 23F, -1F);
      Shape1.setTextureSize(96, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 2);
      Shape2.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape2.setRotationPoint(-7F, 9F, -1F);
      Shape2.setTextureSize(96, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 1.570796F);
      Shape3 = new ModelRenderer(this, 0, 2);
      Shape3.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape3.setRotationPoint(8F, 9F, -1F);
      Shape3.setTextureSize(96, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 1.570796F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 16, 1, 1);
      Shape4.setRotationPoint(-8F, 8F, -1F);
      Shape4.setTextureSize(96, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 16, 1, 1);
      Shape5.setRotationPoint(-8F, 23F, 16F);
      Shape5.setTextureSize(96, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 2);
      Shape6.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape6.setRotationPoint(8F, 9F, 16F);
      Shape6.setTextureSize(96, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 1.570796F);
      Shape7 = new ModelRenderer(this, 0, 2);
      Shape7.addBox(0F, 0F, 0F, 14, 1, 1);
      Shape7.setRotationPoint(-7F, 9F, 16F);
      Shape7.setTextureSize(96, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 1.570796F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 16, 1, 1);
      Shape8.setRotationPoint(-8F, 8F, 16F);
      Shape8.setTextureSize(96, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 6);
      Shape9.addBox(0F, 0F, 0F, 1, 21, 1);
      Shape9.setRotationPoint(7F, 8F, -1F);
      Shape9.setTextureSize(96, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0.7853982F);
      Shape10 = new ModelRenderer(this, 0, 6);
      Shape10.addBox(0F, 0F, 0F, 1, 21, 1);
      Shape10.setRotationPoint(-8F, 9F, -1F);
      Shape10.setTextureSize(96, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, -0.7853982F);
      Shape11 = new ModelRenderer(this, 0, 6);
      Shape11.addBox(0F, 0F, 0F, 1, 21, 1);
      Shape11.setRotationPoint(-8F, 9F, 16F);
      Shape11.setTextureSize(96, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, -0.8028515F);
      Shape12 = new ModelRenderer(this, 0, 6);
      Shape12.addBox(0F, 0F, 0F, 1, 21, 1);
      Shape12.setRotationPoint(7F, 8F, 16F);
      Shape12.setTextureSize(96, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0.7853982F);
      Shape13 = new ModelRenderer(this, 5, 15);
      Shape13.addBox(0F, 0F, 0F, 1, 1, 16);
      Shape13.setRotationPoint(0F, 15F, 0F);
      Shape13.setTextureSize(96, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 1.570796F);
      Shape14 = new ModelRenderer(this, 0, 34);
      Shape14.addBox(0F, 0F, 0F, 21, 1, 8);
      Shape14.setRotationPoint(-1F, 14F, 4F);
      Shape14.setTextureSize(96, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 0, 34);
      Shape15.addBox(0F, 0F, 0F, 21, 1, 8);
      Shape15.setRotationPoint(-1F, 14F, 3F);
      Shape15.setTextureSize(96, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 1.570796F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 0, 34);
      Shape16.addBox(0F, 0F, 0F, 21, 1, 8);
      Shape16.setRotationPoint(-1F, 14F, 12F);
      Shape16.setTextureSize(96, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 1.570796F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 0, 34);
      Shape17.addBox(0F, 0F, 0F, 21, 1, 8);
      Shape17.setRotationPoint(-1F, 5F, 4F);
      Shape17.setTextureSize(96, 64);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 40, 17);
      Shape18.addBox(0F, 0F, 0F, 1, 8, 8);
      Shape18.setRotationPoint(-1F, 6F, 4F);
      Shape18.setTextureSize(96, 64);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 36, 0);
      Shape19.addBox(0F, 0F, 0F, 1, 11, 3);
      Shape19.setRotationPoint(-1F, 15F, 6F);
      Shape19.setTextureSize(96, 64);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0.6632251F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
