response.setContentType(MediaType.IMAGE_JPEG_VALUE);
StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
