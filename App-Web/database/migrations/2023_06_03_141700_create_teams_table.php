<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('teams', function (Blueprint $table) {
            $table->integer("id");
            $table->string('name');
            $table->string('code');
            $table->string('country');
            $table->integer('founded');
            $table->boolean('national');
            $table->string('logo');
            $table->string('address');
            $table->string('city');
            $table->integer('capacity');
            $table->string('surface');
            $table->string('image');
            $table->string('stadium');
            $table->string('league_id');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('teams');
    }
};
